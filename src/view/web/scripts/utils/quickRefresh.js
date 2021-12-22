import { insertRoverImage } from "./insertRoverImage";
import { selectRover } from "./selectRover";

export function quickRefresh(environment) {
    for (let i = 0; i <= environment.topRightCorner.y; i++) {
      for (let j = 0; j <= environment.topRightCorner.x; j++) {
          
        const roverNode = document.querySelector(".mars-grid").children[i].children[j];
        roverNode.style.opacity = 1.0;

        if (environment.mars[i][j] != -1) {

          insertRoverImage(roverNode);
          roverNode.addEventListener("click", (e) => {
            e.stopPropagation();
            selectRover(roverNode, environment);
          });

          if (environment.selectedRover == environment.mars[i][j]) roverNode.style.opacity = "0.5";

        }
        else {
            if (roverNode.hasChildNodes()) {

                roverNode.removeChild(roverNode.firstChild);
                roverNode.innerHTML = "&nbsp";
                roverNode.style.background = 'red';

                const newRoverNode = roverNode.cloneNode(true);
                newRoverNode.setAttribute("positionX", String(j));
                newRoverNode.setAttribute("positionY", String(i));

                roverNode.parentNode.replaceChild(newRoverNode, roverNode);
            }
        }
      }
    }
  }