export function insertRoverImage(element) {
    element.style.background = "rgba(1.0, 1.0, 1.0, 0.0)";
          
    const roverImg = new Image();
    roverImg.src = "assets/spaceship.png";
    roverImg.width = "50";
    roverImg.height = "50";
    roverImg.style.margin = "23px";
  
    element.innerHTML = "";
  
    element.appendChild(roverImg);
  }