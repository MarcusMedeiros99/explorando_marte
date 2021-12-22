
export function sendNewWorlEvent(websocket) {
    const x = Number(document.getElementById("new-world-width").value) - 1;
    const y = Number(document.getElementById("new-world-height").value) - 1;
  
    const data = {
      eventName: "NewWorldEvent",
      event: {
        topRightCorner: {
          x,
          y
        }
      }
    };
  
    websocket.send(JSON.stringify(data));
}

export function sendAddRoverEvent(websocket, x, y) {
    const data = {
      eventName: "AddRoverEvent",
      event: {
        rover: {
          position: {
            x,y
          },
  
        }
      }
    }
    websocket.send(JSON.stringify(data));
}

export function sendRoverCommandEvent(websocket,commandCode, selectedRover) {
  if (selectedRover != -1) {
    const data = {
      eventName: "RoverCommandEvent",
      event: {
        commandCode,
        roverIndex: selectedRover
      }
    }
    websocket.send(JSON.stringify(data));
  }    
}