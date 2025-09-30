## Factory Method Pattern
### Use Case – Document Exporter

In a document editor, users often want to export files in different formats such as PDF, DOCX, HTML, or TXT.
Each format requires different export logic, but the client (user-facing code) should not worry about how each export works.

Instead of the client creating exporters directly using new PdfExporter(), the Factory Method creates the correct exporter object depending on the format requested.

This design makes the system flexible, extensible, and easier to maintain.
For example:

Today, we support PDF, DOCX, HTML, TXT.

Tomorrow, we can add a MarkdownExporter without touching the client code.

### Why is this Factory Method?

The Factory Method Pattern defines an interface for creating an object but lets the subclasses/factory decide which class to instantiate.

Product Interface: DocumentExporter

Concrete Products: PdfExporter, DocxExporter, HtmlExporter, TxtExporter

Factory: SimpleExporterFactory (decides which exporter to create)

Client: Main (only depends on ExporterFactory, not on concrete exporters)

This follows the Open/Closed Principle (SOLID): we can add new exporters without modifying existing code.
It also reduces tight coupling, since the client does not know about specific exporter implementations.