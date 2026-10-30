package com.cocinApp.msvc_ingrediente.testbloqueo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BloqueoCITest {

    @Test
    void pruebaFalloIntencional() {
        assertEquals(10, 5, "Prueba intencional para validar el bloqueo del CI");
    }
}