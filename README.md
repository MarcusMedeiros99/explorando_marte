# Explorando Marte

Esse é um projeto usado para a demonstração de conceitos de POO e design de projetos utilizando Java. Os requisitos funcionais iniciais do projeto podem ser encontrados em https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c


## Antes de rodar
O projeto foi desenvolvido utilizando Java 11 fornecido pela openjdk 11.0.11. É necessária a instalação antes de compilar e executar o programa.
Foram utilizadas as extensões recomendadas na documentação do [VS Code para Java](https://code.visualstudio.com/docs/java/java-tutorial#_setting-up-vs-code-for-java-development). Se instaladas, a geração dos arquivos ```*.class``` deve ocorrer de forma automática com o VS Code aberto, que criará a subpasta ```bin``` com esses arquivos.

## Guia para execução
O programa utiliza um arquivo de texto como entrada, cujo caminho deve ser fornecido como parâmetro. Dentro da pasta do repositório, execute:

```bash
java -cp ./bin App input_path
```

```input_path``` é o caminho do arquivo de entrada, descrito em https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c