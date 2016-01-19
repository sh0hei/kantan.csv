package tabulate

import java.io.{Writer, Closeable}

import tabulate.engine.WriterEngine

trait CsvWriter[A] extends Closeable { self =>
  def write(a: A): CsvWriter[A]

  def write(as: Traversable[A]): CsvWriter[A] = {
    for(a <- as) write(a)
    this
  }

  override def close(): Unit

  def contramap[B](f: B => A): CsvWriter[B] = new CsvWriter[B] {
    override def write(b: B): CsvWriter[B] = {
      self.write(f(b))
      this
    }
    override def close(): Unit = self.close()
  }
}

object CsvWriter {
  def apply[A](writer: Writer, separator: Char, header: Seq[String] = Seq.empty)(implicit ea: RowEncoder[A], engine: WriterEngine): CsvWriter[A] = {
    if(header.isEmpty) engine.writerFor(writer, separator).contramap(ea.encode)
    else {
      val w = engine.writerFor(writer, separator)
      w.write(header)
      w.contramap(ea.encode)
    }
  }
}