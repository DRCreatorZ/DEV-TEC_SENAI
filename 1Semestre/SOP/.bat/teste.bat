@echo off
cls
:menu
cls
color 02

date /t
echo Computador: %computername% Usuario: %username%
echo.
echo Criado por: Dener Ricardo Castravechi
echo.

echo                 **MENU TAREFAS**
echo     =========================================
echo     * 1. Ajustar data                       *
echo     * 2. Ajustar hora                       *
echo     * 3. Fazer Backup                       *
echo     * 4. Detectar erros no Computador       *
echo     * 5. Escanear Disco Local               *
echo     * 6. Corrigir erros do Windows          *
echo     * 7. Limpar Cache                       *
echo     * 8. Verificar Atualizacao do Windows   *
echo     * 9. Sair                               *
echo     =========================================

set /p opcao= Escolha uma opcao:
echo -----------------------------
if %opcao% equ 1 goto opcao1
if %opcao% equ 2 goto opcao2
if %opcao% equ 3 goto opcao3
if %opcao% equ 4 goto opcao4
if %opcao% equ 5 goto opcao5
if %opcao% equ 6 goto opcao6
if %opcao% equ 7 goto opcao7
if %opcao% equ 8 goto opcao8
if %opcao% equ 9 goto opcao9
if %opcao% GEQ 10 goto opcao10

:opcao1
cls
echo =================================================================
echo *Ajustar a data como no modelo e precione "ENTER" para confirmar*
echo =================================================================
date
pause
goto menu

:opcao2
cls
echo ==================================================================
echo *Ajustar a hora como no modelo e precione "ENTER" para confirmar*
echo ==================================================================
time
pause
goto menu

:opcao3
cls
echo =========================================================================================
echo *Todos os Arquivos da Pasta "Arquivos" serao salvos na pasta Backup, apos clicar "ENTER"*
echo =========================================================================================
pause
robocopy C:\Users\AlunoDEVNoturno\Documents\Arquivos C:\Users\DRC\Desktop\Backup
echo ===============================
echo *      Backup Concluido       *
echo ===============================
pause
goto menu

:opcao4
cls
echo ==============================
echo *Fazendo Varredura no Sistema*
echo ==============================
echo ##########################################################
echo #NAO INTERROMPA ESTA ACAO!!!AGUARDE O FIM DA VARREDURA!!!#
echo ##########################################################
sfc /scannow
pause
goto menu

:opcao5
cls
echo ==================================
echo  *Escaneando e Recuperando Disco *
echo ==================================
chkdsk /r
pause
goto menu



:opcao6
cls
echo ================================
echo * Corrigindo erros do Windows  *
echo ================================
DISM /Online /Cleanup-image /Restorehealth
pause
goto menu

:opcao7
cls
echo ==============================
echo *        Limpar Cache        *
echo ==============================
ipconfig /flushdns
pause
goto menu

:opcao8
cls
echo ==============================
echo *      Atualizar Windows     *
echo ==============================
pause
wuauclt.exe/updatenow 
pause
goto menu

:opcao9
cls
exit


:opcao10
echo ===============================================
echo * Opcao Invalida! Escolha outra opcao do menu *
echo ===============================================
pause
goto menu
