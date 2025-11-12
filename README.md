# TP 04 : introduction aux patterns

## Exercice 1
Ce tp s'inspire de la bibliothèque `itertools` de `python`. Nous allons utiliser des décorateur 

Pour travailler sur des suites de chaînes de caractères (par exemple, sur les lignes d'un texte), on a défini la notion de `Sequence`, et fourni une implémentation basée sur un tableau de `Strings`.

On peut très facilement proposer deux autres implémentations, l'une basée sur une *List* (voire une collection) de `String`, l'autre sur un `BufferedReader` de Strings.

### Question 1

Écrivez et testez une classe `UpperCaseDecoratorSequence`, qui sera un *décorateur* de `Sequence`, et qui renverra la séquence des chaînes de caractères, mais en majuscules ;

### Question 2

Écrivez et testez une classe `GrepSequence`, qui sera un *décorateur* de `Sequence`, et qui renverra la séquence des chaînes de caractères de la séquence d'origine qui contiennent un certain texte.

Exemple d'utilisation :

~~~
GrepSequence s = new GrepSequence(autreSequence, "chemin");
String l; 
while ((l = s.ligneSuivante())!= null) {
    print(l); 
}
~~~

imprime les lignes de autreSequence qui contiennent "chemin".

### Question 3

Écrivez et testez une classe `LineNumberSequence`, qui sera un *décorateur* de `Sequence` qui conservera (dans une variable d'instance) le numéro de la dernière ligne lue.

Exemple d'utilisation :

~~~
LineNumberSequence s = new LineNumberSequence(autreSequence);
String l; 
while ((l = s.ligneSuivante())!= null) {
    print(s.getLineNumber());
    print(l); 
}
~~~

### Question 4

On désire maintenant créer une classe `SliceSequence`, qui sera un *décorateur* de `Sequence` qui renverra uniquement une partie 
des lignes de la séquence d'origine. Le constructeur recevra deux entiers, le premier sera l'indice de la première ligne à prendre en compte, et le second celui de la première ligne à ignorer.

~~~
SliceSequence s = new SliceSequence(autreSequence, 10, 20);
String l; 
while ((l = s.ligneSuivante())!= null) {    
    print(l); 
}
~~~

Dans l'exemple précédent, nous affichons le texte entre les lignes 10 (incluse) et la ligne 20 (exclue).

**IMPORTANT :** cette question 4 est beaucoup plus intéressante si vous vous arrangez pour y réutiliser la question 3 !

## Exercice 2

### Question 1
On vous fournit une implémentation du composite qui représente un document XML, avec un exemple qui montre comment on peut extraire le texte contenu dans tout le document.

On vous demande de vous inspirer du code qui est fourni pour écrire les implémentations de la méthode toXML.
 
Note : les attributs seront listés par ordre alphabétique de nom d'attribut (pour que le comportement soit déterministe et simple à définir).

Petite remarque sur le XML produit : dans les tests, nous avons négligé le problème des balises vides comme 
`img`. En théorie, les notations `<img src="toto.png"/>` et `<img src="toto.png"></img>` ne sont pas équivalentes. On pourrait complexifier un peu l'arbre d'héritage pour prendre cela en compte.

# tp04-patterns
