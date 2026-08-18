<?php

function configuracionGoogle(): array
{
    $configuracion = [
        'client_id' => getenv('GOOGLE_CLIENT_ID') ?: '',
        'client_secret' => getenv('GOOGLE_CLIENT_SECRET') ?: '',
        'redirect_uri' => getenv('GOOGLE_REDIRECT_URI') ?: '',
    ];

    $archivoLocal = __DIR__ . '/google_credentials.php';
    if ((!$configuracion['client_id'] || !$configuracion['client_secret']) && is_file($archivoLocal)) {
        $archivoConfiguracion = require $archivoLocal;
        if (is_array($archivoConfiguracion)) {
            $configuracion = array_merge($configuracion, array_filter($archivoConfiguracion, fn ($valor) => $valor !== ''));
        }
    }

    if (!$configuracion['redirect_uri']) {
        $configuracion['redirect_uri'] = 'http://localhost:9000/PHP/google_callback.php';
    }

    return $configuracion;
}

function googleConfigurado(): bool
{
    $configuracion = configuracionGoogle();
    return $configuracion['client_id'] !== '' && $configuracion['client_secret'] !== '';
}
