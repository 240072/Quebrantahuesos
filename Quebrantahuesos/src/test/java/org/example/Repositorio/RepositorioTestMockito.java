package org.example.Repositorio;
import org.example.Models.Bicicleta;
import org.example.Models.Carrera;
import org.example.Models.Ciclista;
import org.example.Models.Equipo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepositorioTestMockito {

    @InjectMocks
    private Repositorio repositorio;

    @Mock
    private List<Ciclista> ciclistasMock;

    @Mock
    private List<Bicicleta> bicicletasMock;

    @Mock
    private List<Equipo> equiposMock;

    @Mock
    private List<Carrera> carrerasMock;

    @Test
    void testGetCiclistas() {
        when(ciclistasMock.size()).thenReturn(5);
        assertEquals(5, repositorio.getCiclistas().size());
    }

    @Test
    void testGetBicicletas() {
        when(bicicletasMock.isEmpty()).thenReturn(false);
        assertFalse(repositorio.getBicicletas().isEmpty());
    }

    @Test
    void testGetEquipos() {
        when(equiposMock.size()).thenReturn(3);
        assertEquals(3, repositorio.getEquipos().size());
    }

    @Test
    void testGetCarreras() {
        when(carrerasMock.isEmpty()).thenReturn(false);
        assertFalse(repositorio.getCarreras().isEmpty());
    }

}