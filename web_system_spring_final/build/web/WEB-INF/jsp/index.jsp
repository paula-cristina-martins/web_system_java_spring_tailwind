<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Padrões de Desenvolvimento</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    </head>
    <body class="bg-gray-100 font-sans">
        <!-- desktop -->
        <div class="hidden md:block bg-gray-800 text-white p-4">
            <div class="flex items-center justify-between pl-10">
                <h1 class="text-xl uppercase">Projeto Java</h1>
                <div class="flex items-center pr-10">
                    <a href="index" class="mx-4 rounded-3xl py-1 px-3 hover:bg-blue-100 hover:text-gray-800">Início</a>
                    <a href="/web_system_spring_final/usuario/inicio" class="mx-4 rounded-3xl py-1 px-3 hover:bg-blue-100 hover:text-gray-800">Usuários</a>
                    <a href="/web_system_spring_final/produto/inicio" class="mx-4 rounded-3xl py-1 px-3 hover:bg-blue-100 hover:text-gray-800">Produtos</a>
                </div>
            </div>
        </div>

        <!-- mobile -->
        <div class="md:hidden bg-gray-800 text-white px-6 py-4">
            <div class="flex items-center justify-between">
                <h1 class="text-xl uppercase">Projeto Java</h1>
                <button id="menu-toggle" class="text-white focus:outline-none">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16m-7 6h7"></path></svg>
                </button>
            </div>
            <div id="menu" class="hidden mt-4 ml-2 uppercase">
                <a href="index" class="block py-2">- Início</a>
                <a href="/web_system_spring_final/usuario/inicio" class="block py-2">- Usuários</a>
                <a href="/web_system_spring_final/produto/inicio" class="block py-2">- Produtos</a>
            </div>
        </div>

        <!-- main -->
        <div class="container mx-auto mt-8">
            <h1 class="text-center text-gray-500 mb-6 text-3xl">Bem-Vindo ao Sistema!</h1>
            <div class="flex justify-center space-x-4">
                <a href="/web_system_spring_final/usuario/inicio" class="bg-blue-500 hover:bg-blue-400 text-white px-4 py-2 rounded-md">Usuários</a>
                <a href="/web_system_spring_final/produto/inicio" class="bg-green-500 hover:bg-green-400 text-white px-4 py-2 rounded-md">Produtos</a>
            </div>
        </div>

        <script>
            document.getElementById('menu-toggle').addEventListener('click', function () {
                document.getElementById('menu').classList.toggle('hidden');
            });
        </script>

    </body>
</html>