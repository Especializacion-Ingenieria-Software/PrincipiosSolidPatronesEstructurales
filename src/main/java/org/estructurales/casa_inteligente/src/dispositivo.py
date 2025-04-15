from abc import ABC, abstractmethod
from typing import Optional


class Dispositivo(ABC):
    """Componente: Interfaz común para todos los objetos"""

    @abstractmethod
    def encender(self) :
        pass

    @abstractmethod
    def apagar(self) :
        pass

    @abstractmethod
    def agregar_dispositivo(self, dispositivo: 'Dispositivo') :
        pass

    @abstractmethod
    def eliminar_dispositivo(self, dispositivo: 'Dispositivo')  :
        pass

    @abstractmethod
    def obtener_dispositivo(self, indice: int) -> Optional['Dispositivo']:
        pass


class DispositivoIndividual(Dispositivo):
    """Leaf: Clase base para dispositivos individuales"""

    def __init__(self, id: str, ubicacion: str):
        self.id = id
        self.ubicacion = ubicacion

    def agregar_dispositivo(self, dispositivo: 'Dispositivo') -> None:
        print(f"No se puede agregar un dispositivo a {self.__class__.__name__} (dispositivo individual)")

    def eliminar_dispositivo(self, dispositivo: 'Dispositivo') -> None:
        print(f"No se puede eliminar un dispositivo de {self.__class__.__name__} (dispositivo individual)")

    def obtener_dispositivo(self, indice: int) -> Optional['Dispositivo']:
        return None