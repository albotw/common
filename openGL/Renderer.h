#pragma once
#include "lib/glad/glad.h"
#include "Engine/Window.h"
#include "Engine/GL/Shader.hpp"
#include "Engine/Mesh.h"

class Renderer
{
public:
	Renderer();

	void init();
	void render(Window* w, Mesh* m);

	void flush();

private:
	Shader* shader;
};

