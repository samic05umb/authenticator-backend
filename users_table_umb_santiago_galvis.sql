-- public.users definicion tabla de postgres, compatible con Oracle por favor cambiar drivers y url si va a usar otra base de datos.

CREATE TABLE public.users (
	id serial NOT NULL,
	tipo_documento varchar NULL,
	numero_documento int4 NOT NULL,
	nombre varchar NULL,
	apellido varchar NULL,
	usuario varchar NULL,
	clave varchar NULL,
	numero_celular varchar NULL,
	correo_electronico varchar NULL,
	CONSTRAINT users_pkey PRIMARY KEY (numero_documento)
);

INSERT INTO public.users (tipo_documento,numero_documento,nombre,apellido,usuario,clave,numero_celular,correo_electronico) VALUES 
('cedula',1000000000,'santiago','galvis','samic','clave123','3001234567','correo@gmail.com')
;
