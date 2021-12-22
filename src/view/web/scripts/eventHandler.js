import { quickRefresh } from "./utils/quickRefresh";
import { refresh } from "./utils/refresh";

function connectionEventHandler(connectionEvent, environment) {
    environment
      .topRightCorner
      .x = connectionEvent.environment.world?.topRightCorner.x;
    environment
      .topRightCorner
      .y = connectionEvent.environment.world?.topRightCorner.y;
  
    environment
      .rovers = [];
    environment
      .rovers = connectionEvent.environment?.rovers;
    
    environment
      .mars = [];
    for (let i = 0; i <= environment.topRightCorner.y; i++) {
      environment.mars.push([]);
      for (let j = 0; j <= environment.topRightCorner.x; j++) {
        environment.mars[i].push(-1);
      } 
    }
  
    for (let i = 0; i < environment.rovers.length; i++) {
      const rover = environment.rovers[i];
      environment.mars[environment.topRightCorner.y - rover.position.y][rover.position.x] = i;
    }
  
    refresh(environment);
}

function newWorldEventHandler(newWorldEvent, environment) {
    environment
      .topRightCorner.x = newWorldEvent.topRightCorner.x;
    environment
      .topRightCorner.y = newWorldEvent.topRightCorner.y;
  
    environment.mars = []
    environment.rovers = []
    for (let i = 0; i <= environment.topRightCorner.y; i++) {
      environment.mars.push([]);
      for (let j = 0; j <= environment.topRightCorner.x; j++) {
        environment.mars[i].push(-1);
      } 
    }
  
    refresh(environment);
}

function addRoverEventHandler(addRoverEvent, environment) {
    const rover = {
      position: addRoverEvent.rover.position,
      direction: addRoverEvent.rover.direction
    };
  
    environment.mars[environment.topRightCorner.y - rover.position.y][rover.position.x] = environment.rovers.length;
    environment.rovers.push(rover);
    
    quickRefresh(environment);
}


function roverCommandEventHandler(roverCommandEvent, environment) {
  const roverIndex = roverCommandEvent.roverIndex;
  const rover = roverCommandEvent.rover;
  
  environment.mars[environment.topRightCorner.y - environment.rovers[roverIndex].position.y][environment.rovers[roverIndex].position.x] = -1;  

  environment.mars[environment.topRightCorner.y - rover.position.y][rover.position.x] = roverCommandEvent.roverIndex;
  environment.rovers[roverIndex] = rover;

  quickRefresh(environment);
}

export function eventHandler (e, environment) {
    const data = JSON.parse(e.data);
  
    switch (data.eventName) {
      case "ConnectionEvent":
        connectionEventHandler(data.event, environment);
        break;
      case "NewWorldEvent":
        newWorldEventHandler(data.event, environment);
        break;
      case "AddRoverEvent":
        addRoverEventHandler(data.event, environment);
        break;
      case "RoverCommandEvent":
        roverCommandEventHandler(data.event, environment);
        break;
      default:
        console.log("Unknown event received");
        break;
    }
  }