@echo off
cls
:menu
cls
color 02
date /t
echo Computador: %computername%         Usuario: %username%
echo                MENU TAREFAS
echo ===========================================
echo * 1. Desligar Imediatamente               *
echo * 2. Desligar em 30 segundos              *
echo * 3. Reiniciar                            *
echo * 4. Limpar Lixeira e Reiniciar           *
echo * 5. Sair                                 *
echo ===========================================

set /p opcao= Escolha uma opcao:
echo -------------------------------------------
if %opcao% equ 1 goto opcao1
if %opcao% equ 2 goto opcao2
if %opcao% equ 3 goto opcao3
if %opcao% equ 4 goto opcao4
if %opcao% equ 5 goto opcao5
if %opcao% geq 6 goto opcao6

:opcao1
cls
echo ===============================================
echo *            Desligando Computador            *
echo ===============================================
pause
shutdown -s -t 0
goto menu

:opcao2
cls
echo ===============================================
echo *     Desligando Computador em 30 segundos    *
echo ===============================================
pause
shutdown -s -t 30
goto menu

:opcao3
cls
echo ===============================================
echo *            Reiniciando Computador           *
echo ===============================================
shutdown -r -t 30
pause
goto menu

:opcao4
cls
rd /S /Q c:\$Recycle.bin
echo ===============================================
echo *              Lixeira Esvaziada              *
echo ===============================================
pause
echo ===============================================
echo *            Reiniciando Computador           *
echo ===============================================
shutdown -r -t 30
pause
goto menu

:opcao5
cls
exit

:opcao6
echo ===============================================
echo * Opcao Invalida! Escolha outra opcao do Menu *
echo ===============================================
pause
goto menu

