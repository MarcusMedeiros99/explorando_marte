import { eventHandler } from "./eventHandler";
import { sendNewWorlEvent, sendAddRoverEvent, sendRoverCommandEvent } from "./sendEvent";

const host = document.location.host;
const path = document.location.pathname;


// const wsUri = `ws://localhost:8080/explorandomarte-1.0-SNAPSHOT/rover`;

const wsUri = `ws://${host}${path}rover`;
const websocket = new WebSocket(wsUri);

const environment = {
  rovers: [],
  mars: [],
  selectedRover: -1,
  topRightCorner: {
    x: -1,
    y: -1
  },
  marsView: document.querySelector(".mars-grid")
}

environment.marsView.addEventListener("click", (e) => {
  const x = Number(e.target.getAttribute("positionX"));
  const y = environment.topRightCorner.y - Number(e.target.getAttribute("positionY"));

  sendAddRoverEvent(websocket,x, y);
});

document.addEventListener("keydown", (e) => {
  const key = e.key;
    
  switch (key) {
    case "w":
      sendRoverCommandEvent(websocket, "MOVE_FORWARD", environment.selectedRover);
      break;
    case "a":
      break;
    case "s":

      break;
    case "d":

      break;
    case "q":
      sendRoverCommandEvent(websocket, "ROTATE_LEFT", environment.selectedRover);
      break;
    case "e":
      sendRoverCommandEvent(websocket, "ROTATE_RIGHT", environment.selectedRover);
      break;
    default:
      break;
  }
});



websocket.onopen = () => {
  console.log("Connected!!")
}
websocket.onmessage = (e) => {eventHandler(e,environment)};

const newWorldBtn = document.getElementById("new-world-btn");
newWorldBtn.addEventListener("click", (e) => {sendNewWorlEvent(websocket)} );