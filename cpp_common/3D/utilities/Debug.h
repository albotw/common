#pragma once
void APIENTRY glDebugOutput(GLenum source, GLenum type, GLuint id, GLenum severity, GLsizei length, const GLchar *message, const void *userParam);
void activateGLFWDebug();

#define glCheckError() glCheckError_(__FILE__, __LINE__)
GLenum glCheckError_(const char *file, int line);