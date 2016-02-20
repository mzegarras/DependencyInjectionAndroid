<h1>Dependency Injection Android</h1>
<p>
La inyección de dependencias(DI) simplifica el desarrollo de aplicaciones, Spring es probablemente ek mejor framework de DI.
 Sin embargo, en android tenemos otras alternativas:
</p>

<ul>
<li>1. RoboGuice</li>
<li>2. Dagger 2</li>
<li>3. Butter Knife</li>
</lu>
<p>
Para las personas que hemos trabajado con base de datos(SQL Lite) es común utiliar el siguiente código:</p>
<code>
DatabaseHelper databaseHelper = new DatabaseHelper(application);
</code>

<p>
Si tenemos 30 fragmentos, que utilizan acceso a base de datos entonces, este código se  volverá a escribir. El código previo lo podemos mejorar de la siguiente manera:
</p>

<code>
@Inject DatabaseHelper databaseHelper;
</code>

<p>
También es común utilizar preferencias, componentes de acceso a web services o validaciones, etc. Entonces podemos utiliar la DI para inyectarlo en nuestras activities, fragments, etc.
</p>

<p>
<code>
@Inject IValidateApi networkApi;
</code>
</p>

<p>
<code>@Inject SharedPreferences sharedPreferences;</code>
</p>


<p>
<code>@Inject DatabaseHelper databaseHelper;</code>
</p>


<p>
Otro punto importante dentro de DI es utilizar interfaces o clases abstractas para minimizar la cohesión. El componente  networkApi lo podemos reemplazar con clases concretas:
</p>


<p>
<code>@Inject IValidateApi networkApi;</code>
</p>

<p>
<code>public class DbServiceValidateApi implements IValidateApi </code>
</p>

<p>
<code>public class RestServiceValidateApi implements IvalidateApi</code>
</p>


<p>
Todo esto ha sido posible gracias a Dagger 2.

Adicionalmente, también podemos usar la inyección en las vistas por ejemplo:
</p>
<code>
activity. textView = (android.widget.TextView) activity.findViewById(R.id.textView);

@Bind(R.id.textView)
TextView textView;
</code>
<p>
Para la inyección de vista he utilizado: butterknife.

Las fuentes para armar este pequeño ejemplo fueron:

http://jakewharton.github.io/butterknife/
https://github.com/hosainnet/AndroidDagger2Example
<p>

Por último, el código fuente de la aplicación completa la encuentran en:

https://github.com/mzegarras/DependencyInjectionAndroid.git
