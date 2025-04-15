from src.dispositivo import DispositivoIndividual


class CamaraSeguridad(DispositivoIndividual):
    def encender(self):
        print(f"Cámara de seguridad {self.id} en {self.ubicacion} encendida y grabando")

    def apagar(self):
        print(f"Cámara de seguridad {self.id} en {self.ubicacion} apagada")