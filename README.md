# Explorando Marte

Esse é um projeto usado para a demonstração de conceitos de POO e design de projetos utilizando Java. Os requisitos funcionais iniciais do projeto podem ser encontrados em https://gist.github.com/elo7-developer/1a40c96a5d062b69f02c . O jogo foi adaptado para funcionar através de entradas via websocket.


## Antes de rodar
O programa foi testado utilizando:
    - Java SE 11
    - Apache Maven 3.8.4
    - Apache Tomcat 10.0.14

## Instalação

### Baixe o repositório

```bash
git pull https://github.com/MarcusMedeiros99/explorando_marte.git
```

Alternativamente, com ssh:

```bash
git pull git@github.com:MarcusMedeiros99/explorando_marte.git
```

### Use o Maven para instalar dependências e gerar um arquivo WAR

Dentro da pasta do repositório:

```bash

    mvn package -f pom.xml

```

Uma pasta ```bin``` deve ter sido criada e dentro dela, um arquivo .WAR. Use o manager do Apache Tomcat para fazer o deploy da aplicação.

## Interface gráfica

Em desenvolvimento.

## API

Para a comunicação com endpoint, são utilizadas _Mensagens_ em formato JSON stringficado por meio de uma conexão websocket.  Uma vez que uma _Mensagem_ é enviada para o endpoint do servidor, ela é enviada via broadcast para todos os outros endpoints. Todas as mensagens devem ter o formato abaixo.



```javascript

{
	eventName: string,
	event: Object
}

```

### Usando a API via navegador

```javascript

const host = document.location.host;
const path = document.location.pathname;


const wsUri = `ws://${host}${path}rover`;
const websocket = new WebSocket(wsUri);

const message = // yourMessage

websocket.send(JSON.stringify(message));

websocket.onmessage = (e) {
	const message = e.data;

	switch (message.eventName) {
		// handle events
	}
}

```

### eventName

Uma string representando o nome do evento. Pode assumir um dos seguintes valores.

- "AddRoverEvent"
- "ConnectionEvent"
- "NewWorldEvent"
- "RoverCommandEvent"

### event
## AddRoverEvent
```javascript
rover: {
	position: {
		x: int,
		y: int
	}
}
```

## ConnectionEvent

Evento enviado de volta quando a conexão com o socket é feita. Serve para verificar se já existe um Environment com mapa e sondas.

```javascript

environment: {
	world: {
		topRightCorner: 
			x: int,
			y: int
		},
		occupiedPositions: boolean[][],
		rovers: rover[] //rover mostrado em AddRoverEvent
	}
}

```

## NewWorldEvent
```javascript
{
	position: { //posição do canto superior direito (largura+1, altura+1)
		x: int,
		y: int
	}
}
```

## RoverCommandEvent

```javascript
{
	commandCode: string, //deve assumir um valor válido
	roverIndex: int
}
```

```commandCode``` dever ser: "MOVE_FORWARD", "ROTATE_LEFT" ou "ROTATE_RIGHT".


