#pragma once
#include <vector>
#include <string>
#include "assimp/scene.h"

#include "../GL/Shader.hpp"
#include "Mesh.h"

using namespace std;
class Model
{
public:
	vector<Mesh> meshes;
	string directory;
	vector<Texture> textures_loaded;
	bool gammaCorrection;

	Model(string const& path);
	void Draw(Shader shader);

private:
	void loadModel(string path);
	void processNode(aiNode* node, const aiScene* scene);
	Mesh processMesh(aiMesh* mesh, const aiScene* scene);
	vector<Texture> loadMaterialTexture(aiMaterial* mat, aiTextureType type, string typeName);
};

