from src.dispositivo import DispositivoIndividual


class Luz(DispositivoIndividual):
    def encender(self) -> None:
        print(f"Luz {self.id} en {self.ubicacion} encendida")

    def apagar(self) -> None:
        print(f"Luz {self.id} en {self.ubicacion} apagada")