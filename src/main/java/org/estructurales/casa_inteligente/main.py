from src.dispositivos import (Luz, Termostato, CamaraSeguridad, PuertaAutomatica)


from src.grupo_dispositivos import GrupoDispositivos


def main():
    # Crear dispositivos individuales
    luz_salon = Luz("L001", "Salón")
    luz_cocina = Luz ("L002", "Cocina")
    luz_dormitorio = Luz("L003", "Dormitorio")

    termostato_salon = Termostato("T001", "Salón")

    camara_entrada = CamaraSeguridad("C001", "Entrada")
    camara_jardin = CamaraSeguridad("C002", "Jardín")

    puerta_principal = PuertaAutomatica("P001", "Entrada principal")

    # Crear grupos de dispositivos
    grupo_luces = GrupoDispositivos("Luces de la casa")
    grupo_luces.agregar_dispositivo(luz_salon)
    grupo_luces.agregar_dispositivo(luz_cocina)
    grupo_luces.agregar_dispositivo(luz_dormitorio)

    grupo_seguridad = GrupoDispositivos("Sistema de seguridad")
    grupo_seguridad.agregar_dispositivo(camara_entrada)
    grupo_seguridad.agregar_dispositivo(camara_jardin)
    grupo_seguridad.agregar_dispositivo(puerta_principal)

    # Crear un grupo que contenga otros grupos
    casa_completa = GrupoDispositivos("Casa completa")
    casa_completa.agregar_dispositivo(grupo_luces)
    casa_completa.agregar_dispositivo(grupo_seguridad)
    casa_completa.agregar_dispositivo(termostato_salon)

    print("\n=== Demostración de dispositivo individual ===")
    luz_salon.encender()
    luz_salon.apagar()

    print("\n=== Demostración de grupo simple ===")
    grupo_luces.encender()
    grupo_luces.apagar()

    print("\n=== Demostración de grupo compuesto ===")
    casa_completa.encender()

    print("\n=== Demostración de operaciones no válidas ===")
    luz_salon.agregar_dispositivo(luz_cocina)

    print("\n=== Demostración de eliminación de dispositivo ===")
    grupo_luces.eliminar_dispositivo(luz_cocina)
    grupo_luces.encender()


if __name__ == "__main__":
    main()