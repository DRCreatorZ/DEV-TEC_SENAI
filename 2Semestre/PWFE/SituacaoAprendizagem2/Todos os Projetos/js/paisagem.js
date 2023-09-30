window.addEventListener("orientationchange", function () {
    if (window.orientation === 90 || window.orientation === -90) {
      // Dispositivo está em modo paisagem
    } else {
      // Forçar o modo paisagem
      screen.orientation.lock("landscape");
    }
  });
  