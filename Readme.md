
This is a minimal reproduction for a java.lang.StackOverflowError in case of cyclic references in POJOs during CRD generation.

The complete StackTrace is in `out.log` and is reproducible by running:

```bash
mvn clean compile -e
```
