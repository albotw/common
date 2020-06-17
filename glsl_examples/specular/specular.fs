#version 430 core

in vec3 Normal;
in vec3 FragPos;

uniform vec3 lightPos;
uniform vec3 lightColor;
uniform vec3 objectColor;
uniform vec3 viewPos;

uniform int lightingMode;

out vec4 FragColor;

vec3 ambient;
vec3 diffuse;
vec3 specular;

vec3 lightDir;
vec3 norm;

void main()
{
	//ambient
	if (lightingMode == 2 || lightingMode == 3 || lightingMode == 4){
		float ambientStrength = 0.3;
		ambient = ambientStrength * lightColor;
	}
	else{
		ambient = vec3(1.0f);
	}

	//diffuse
	if(lightingMode == 3 || lightingMode == 4){
		norm = normalize(Normal);
		lightDir = normalize(lightPos - FragPos);
		float diff = max(dot(norm, lightDir), 0.0);
		diffuse = diff* lightColor;
	}
	else{
		diffuse = vec3(0.0f);
	}

	//specular
	if (lightingMode == 4){
		float specularStrength = 0.5;
		vec3 viewDir = normalize(viewPos - FragPos);
		vec3 reflectDir = reflect(- lightDir, norm);
		float spec = pow(max(dot(viewDir, reflectDir), 0.0), 32);
		specular = specularStrength * spec * lightColor;
	}
	else{
		specular = vec3(0.0f);
	}

	vec3 result = (ambient + diffuse + specular) * objectColor;
	FragColor = vec4(result, 1.0);
}
