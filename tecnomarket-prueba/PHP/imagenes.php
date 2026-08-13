<?php
function subirImagenProducto(array $archivo, string $directorio): array
{
    if (($archivo['error'] ?? UPLOAD_ERR_NO_FILE) !== UPLOAD_ERR_OK)
        return [false, '', 'No se seleccionó una imagen válida.'];
    $tipos = ['image/jpeg' => 'jpg', 'image/png' => 'png', 'image/webp' => 'webp'];
    $tipo = mime_content_type($archivo['tmp_name']);
    if (!isset($tipos[$tipo]))
        return [false, '', 'La imagen debe ser JPG, PNG o WEBP.'];
    if ($archivo['size'] > 5 * 1024 * 1024)
        return [false, '', 'La imagen no puede superar 5 MB.'];
    if (!is_dir($directorio))
        mkdir($directorio, 0775, true);
    $nombre = uniqid('prod_', true) . '.' . $tipos[$tipo];
    if (!move_uploaded_file($archivo['tmp_name'], $directorio . '/' . $nombre))
        return [false, '', 'No se pudo guardar la imagen.'];
    return [true, 'uploads/' . $nombre, ''];
}
