var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {

var numeroAleatorio = Math.floor(Math.random() * 250) + 1;
    var palpites = document.querySelector('.palpites');
    var ultimoResultado = document.querySelector('.ultimoResultado');
    var baixoOuAlto = document.querySelector('.baixoOuAlto');
    var envioPalpite = document.querySelector('.envioPalpite');
    var campoPalpite = document.querySelector('.campoPalpite');
    var contagemPalpite = 1;
    var tentativaCerta = document.querySelector('.tentativaCerta');
    var botaoReinicio;

    function conferirPalpite() {
      var palpiteUsuario = Number(campoPalpite.value);
      var palpiteContagem = Number(contagemPalpite); 
      palpites.textContent = 'Tentativa ' + palpiteContagem + ' de 20';

      if (palpiteUsuario > numeroAleatorio) {
        baixoOuAlto.textContent = 'O meu numero e menor. Tente de novo.';
      } else { 
       if (palpiteUsuario < numeroAleatorio) {
        baixoOuAlto.textContent = 'O meu numero e maior. Tente de novo.';
      } else {
      tentativaCerta.textContent = 'Parabens voce acertou meu numero em ' + contagemPalpite + ' tentativa(s)';
      GameOver();
        if(contagemPalpite == 1) {
          ultimoResultado.textContent='Que Sorte!' ;
        } if(contagemPalpite < 11 && contagemPalpite > 1) {
          ultimoResultado.textContent = 'Muito Bem!!';
        } if (contagemPalpite > 10) {
        	ultimoResultado.textContent = ' '
        }
      }
      if (contagemPalpite > 19) {
      	ultimoResultado.textContent = 'Infelizmente voce perdeu! Meu numero foi ' + numeroAleatorio;
        GameOver();
      }
	}
      contagemPalpite++;
      campoPalpite.value = '';
    }

    envioPalpite.addEventListener('click', conferirPalpite);

    function GameOver() {
      campoPalpite.disabled = true;
      envioPalpite.disabled = true;
      botaoReinicio = document.createElement('button');
      botaoReinicio.textContent = 'Iniciar novo jogo';
      document.body.appendChild(botaoReinicio);
      botaoReinicio.addEventListener('click', reiniciarJogo);
    }

    function reiniciarJogo() {
      contagemPalpite = 1;
      var resetParas = document.querySelectorAll('.resultParas p');
      for(var i = 0 ; i < resetParas.length ; i++) {
        resetParas[i].textContent='';
      }

      botaoReinicio.parentNode.removeChild(botaoReinicio);
      campoPalpite.disabled = false;
      envioPalpite.disabled = false;
      campoPalpite.value='';
      campoPalpite.focus();
      ultimoResultado.style.backgroundColor='white';
      numeroAleatorio=Math.floor(Math.random() * 250) + 1;
    }

});