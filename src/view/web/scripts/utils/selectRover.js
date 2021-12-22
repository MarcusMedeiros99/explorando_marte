import { quickRefresh } from "./quickRefresh";

export function selectRover(roverNode, environment) {

    const x = Number(roverNode.getAttribute("positionX"));
    const y = Number(roverNode.getAttribute("positionY"));
    
    environment.selectedRover = environment.mars[y][x];

    quickRefresh(environment);
}