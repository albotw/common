#pragma once
#include "lib/glad/glad.h"
#include "Engine/IGame.h"
#include "Engine/Mesh.h"
#include "Renderer.h"

class TestGame : public Game
{

public:
	TestGame();
	void init();
	void input(Window* w);
	void update(float interval);
	void render(Window* w);
	void flush();

private:
	Mesh* m;
	Renderer* r;

	Shader* shader;
};

