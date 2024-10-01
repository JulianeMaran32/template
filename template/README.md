### Exemplo completo de Dockerfile

```dockerfile
# Usar a imagem base do OpenJDK 21
FROM openjdk:21.0.4-jdk
LABEL authors="juliane"

# Definir o locale para pt_BR e a codificação de plataforma para UTF-8
ENV LANG=pt_BR.UTF-8
ENV LANGUAGE=pt_BR:pt
ENV LC_ALL=pt_BR.UTF-8

# Instalar o Apache Maven 3.9.9
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://archive.apache.org/dist/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz && \
    tar xzvf apache-maven-3.9.9-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.9.9 /opt/maven && \
    ln -s /opt/maven/bin/mvn /usr/bin/mvn && \
    rm apache-maven-3.9.9-bin.tar.gz

# Adicionar o arquivo JAR da aplicação
COPY template-0.0.1.jar /app/template-0.0.1.jar

# Definir o diretório de trabalho
WORKDIR /app

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "template-0.0.1.jar"]
```