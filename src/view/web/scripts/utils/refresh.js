import { insertRoverImage } from "./insertRoverImage";
import { selectRover } from "./selectRover";

export function refresh(environment) {
    const marsView = environment.marsView;


    while (marsView.firstChild) marsView.removeChild(marsView.lastChild);
  
    for (let i = 0; i <= environment.topRightCorner.y; i++) {
      const row = document.createElement("div");
    
      row.classList.add("d-flex");
      
      for (let j = 0; j <= environment.topRightCorner.x; j++) {
        const col = document.createElement("div");
    
        col.classList.add("border");
        col.classList.add("border-secondary");
    
        col.innerHTML = "&nbsp";
  
        col.setAttribute("positionX", String(j));
        col.setAttribute("positionY", String(i));
        
  
        if (environment.mars[i][j] != -1) {
          insertRoverImage(col);
          col.addEventListener("click", (e) => {
            e.stopPropagation();
            selectRover(col, environment);
          });

        }
        row.appendChild(col);
      }
      marsView.appendChild(row);
    }
  }