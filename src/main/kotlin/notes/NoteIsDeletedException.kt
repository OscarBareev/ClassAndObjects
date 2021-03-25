package notes

import java.lang.RuntimeException

class NoteIsDeletedException(message: String) : RuntimeException(message)