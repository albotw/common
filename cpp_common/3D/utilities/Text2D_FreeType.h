#pragma once

#include <string>
#include <iostream>
#include "../GL/Shader.hpp"

class Font {
public:
	Font(const char* fontPath, int WIDTH, int HEIGHT);
	void printText2D_FT(std::string text, GLfloat x, GLfloat y, GLfloat scale, glm::vec3 color);
	GLuint VAO, VBO;
	Shader* textShader;

};