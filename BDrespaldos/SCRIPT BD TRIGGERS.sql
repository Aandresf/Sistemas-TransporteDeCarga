-- Crear la función que realizará la actualización
CREATE FUNCTION actualizar_identificacion_transportista()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE TRANSPORTISTAS_LICENCIAS
    SET TRANSPORTISTA = NEW.DOCUMENTO
    WHERE TRANSPORTISTA = OLD.DOCUMENTO;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que llamará a la función después de actualizar la identificación del transportista
CREATE TRIGGER trg_actualizar_identificacion_transportista
AFTER UPDATE OF DOCUMENTO
ON PERSONAS
FOR EACH ROW
EXECUTE FUNCTION actualizar_identificacion_transportista();