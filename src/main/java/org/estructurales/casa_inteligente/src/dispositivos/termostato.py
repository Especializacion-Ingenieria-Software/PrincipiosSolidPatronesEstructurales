from src.dispositivo import DispositivoIndividual


class Termostato(DispositivoIndividual):
    def __init__(self, id: str, ubicacion: str):
        super().__init__(id, ubicacion)
        self.temperatura = 21.0  # Temperatura por defecto en °C

    def encender(self) -> None:
        print(f"Termostato {self.id} en {self.ubicacion} encendido a {self.temperatura}°C")

    def apagar(self) -> None:
        print(f"Termostato {self.id} en {self.ubicacion} apagado")

    def ajustar_temperatura(self, temperatura: float) -> None:
        self.temperatura = temperatura
        print(f"Termostato {self.id} ajustado a {self.temperatura}°C")