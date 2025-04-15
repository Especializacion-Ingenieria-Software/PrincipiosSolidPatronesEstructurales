from src.dispositivo import DispositivoIndividual


class PuertaAutomatica(DispositivoIndividual):
    def encender(self) -> None:
        print(f"Puerta automática {self.id} en {self.ubicacion} desbloqueada y operativa")

    def apagar(self) -> None:
        print(f"Puerta automática {self.id} en {self.ubicacion} bloqueada")