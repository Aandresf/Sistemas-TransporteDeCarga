# Sistemas-TransporteDeCarga

pg_dump -U postgres -F c -d BD_TRANSPORTES -f C:\Users\arnal\OneDrive\Escritorio\SISTEMAS\PROYECTO_TRANSPORTISTAS\BDrespaldos\respaldo.tar
pg_restore -U postgres -d BD_TRANSPORTES C:\Users\arnal\OneDrive\Escritorio\SISTEMAS\PROYECTO_TRANSPORTISTAS\BDrespaldos\respaldo.tar



-- Crear la base de datos
-- cambiar BD_TRANSPORTES por el nombre de la base de datos creada
-- cambiar la ruta a donde esta el archivo de respaldo

-- Ajustar la conexión el el archivo database del proyecto
