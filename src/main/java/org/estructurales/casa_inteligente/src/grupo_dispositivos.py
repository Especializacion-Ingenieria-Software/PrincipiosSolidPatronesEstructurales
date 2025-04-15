from typing import List, Optional
from src.dispositivo import Dispositivo


class GrupoDispositivos(Dispositivo):
    """Composite: Grupo de dispositivos"""

    def __init__(self, nombre: str):
        self.nombre = nombre
        self.dispositivos: List[Dispositivo] = []

    def encender(self) -> None:
        print(f"Encendiendo grupo de dispositivos '{self.nombre}':")
        for dispositivo in self.dispositivos:
            dispositivo.encender()

    def apagar(self) -> None:
        print(f"Apagando grupo de dispositivos '{self.nombre}':")
        for dispositivo in self.dispositivos:
            dispositivo.apagar()

    def agregar_dispositivo(self, dispositivo: Dispositivo) -> None:
        self.dispositivos.append(dispositivo)
        print(f"Dispositivo agregado al grupo '{self.nombre}'")

    def eliminar_dispositivo(self, dispositivo: Dispositivo) -> None:
        if dispositivo in self.dispositivos:
            self.dispositivos.remove(dispositivo)
            print(f"Dispositivo eliminado del grupo '{self.nombre}'")
        else:
            print(f"Dispositivo no encontrado en el grupo '{self.nombre}'")

    def obtener_dispositivo(self, indice: int) -> Optional[Dispositivo]:
        if 0 <= indice < len(self.dispositivos):
            return self.dispositivos[indice]
        return None