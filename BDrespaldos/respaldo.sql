--
-- PostgreSQL database dump
--

-- Dumped from database version 17.0
-- Dumped by pg_dump version 17.0

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: actualizar_identificacion_transportista(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.actualizar_identificacion_transportista() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    UPDATE TRANSPORTISTAS_LICENCIAS
    SET TRANSPORTISTA = NEW.DOCUMENTO
    WHERE TRANSPORTISTA = OLD.DOCUMENTO;
    RETURN NEW;
END;
$$;


ALTER FUNCTION public.actualizar_identificacion_transportista() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: licencias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.licencias (
    codigo integer NOT NULL,
    grado character varying(20) NOT NULL,
    detalles character varying(100) NOT NULL
);


ALTER TABLE public.licencias OWNER TO postgres;

--
-- Name: licencias_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.licencias_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.licencias_codigo_seq OWNER TO postgres;

--
-- Name: licencias_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.licencias_codigo_seq OWNED BY public.licencias.codigo;


--
-- Name: personas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personas (
    id integer NOT NULL,
    documento integer NOT NULL,
    nombre character varying(100) NOT NULL,
    telefono character varying(15),
    correo character varying(30),
    tipo character varying(1) NOT NULL,
    categoria integer NOT NULL,
    estatus integer NOT NULL
);


ALTER TABLE public.personas OWNER TO postgres;

--
-- Name: personas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.personas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.personas_id_seq OWNER TO postgres;

--
-- Name: personas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.personas_id_seq OWNED BY public.personas.id;


--
-- Name: transportistas_licencias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transportistas_licencias (
    id integer NOT NULL,
    transportista integer NOT NULL,
    licencia integer NOT NULL,
    codigo character varying(20) NOT NULL,
    vencimiento date NOT NULL,
    estatus integer NOT NULL
);


ALTER TABLE public.transportistas_licencias OWNER TO postgres;

--
-- Name: transportistas_licencias_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transportistas_licencias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.transportistas_licencias_id_seq OWNER TO postgres;

--
-- Name: transportistas_licencias_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transportistas_licencias_id_seq OWNED BY public.transportistas_licencias.id;


--
-- Name: licencias codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.licencias ALTER COLUMN codigo SET DEFAULT nextval('public.licencias_codigo_seq'::regclass);


--
-- Name: personas id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personas ALTER COLUMN id SET DEFAULT nextval('public.personas_id_seq'::regclass);


--
-- Name: transportistas_licencias id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transportistas_licencias ALTER COLUMN id SET DEFAULT nextval('public.transportistas_licencias_id_seq'::regclass);


--
-- Data for Name: licencias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.licencias (codigo, grado, detalles) FROM stdin;
1	PRIMER GRADO	VEHICULOS DE TRACCION HUMANA O ANIMAL
2	SEGUNDO GRADO	MOTOCICLETAS
3	TERCER GRADO	AUTOMOVIL, HASTA 9 PUESTOS O 2,5 TN DE MERCANCIA
4	CUARTO GRADO	TRANSPORTE, HASTA 12 PUESTOS O 6 TN DE MERCANCIA
5	QUINTO GRADO	TRANSPORTE, HASTA 33 PUESTOS O 9 TN DE MERCANCIA
6	T.S.P	TRANSPORTE, SUPERIOR A 33 PUESTOS O 9 TN DE MERCANCIA
\.


--
-- Data for Name: personas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personas (id, documento, nombre, telefono, correo, tipo, categoria, estatus) FROM stdin;
2	80000002	Transportista 2	04141234568	trans2@example.com	V	2	1
3	80000003	Transportista 3	04141234569	trans3@example.com	V	2	1
4	80000004	Transportista 4	04141234570	trans4@example.com	V	2	1
5	80000005	Transportista 5	04141234571	trans5@example.com	V	2	1
6	90000001	Cliente 1	04141234572	cliente1@example.com	E	1	1
7	90000002	Cliente 2	04141234573	cliente2@example.com	J	1	1
8	90000003	Cliente 3	04141234574	cliente3@example.com	G	1	1
9	90000004	Cliente 4	04141234575	cliente4@example.com	E	1	1
10	90000005	Cliente 5	04141234576	cliente5@example.com	J	1	1
11	10000001	Propietario 1	04141234577	prop1@example.com	G	3	1
12	10000002	Propietario 2	04141234578	prop2@example.com	E	3	1
13	10000003	Propietario 3	04141234579	prop3@example.com	J	3	1
14	10000004	Propietario 4	04141234580	prop4@example.com	V	3	1
15	10000005	Propietario 5	04141234581	prop5@example.com	E	3	1
1	80000001	Transportista 1	04141234567	trans1@example.com	V	2	1
16	27747762	arnadlo			V	2	1
17	26446530	FLORES			V	2	1
18	8189523	NANCYS			V	2	1
\.


--
-- Data for Name: transportistas_licencias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transportistas_licencias (id, transportista, licencia, codigo, vencimiento, estatus) FROM stdin;
4	80000002	2	2	2024-12-31	1
5	80000002	4	4	2024-12-31	1
6	80000002	5	5	2024-12-31	1
7	80000003	2	2	2024-12-31	1
8	80000003	5	5	2024-12-31	1
9	80000003	6	6	2024-12-31	1
10	80000004	2	2	2024-12-31	1
11	80000004	3	3	2024-12-31	1
12	80000004	5	5	2024-12-31	1
13	80000005	2	2	2024-12-31	1
14	80000005	4	4	2024-12-31	1
15	80000005	6	6	2024-12-31	1
1	80000001	2	2	2024-12-31	1
2	80000001	3	3	2024-12-31	1
3	80000001	4	4	2024-12-31	1
16	80000001	6	232323	2024-11-30	1
17	27747762	2	2332323	2025-01-01	1
18	26446530	1	121212	2024-12-31	99
\.


--
-- Name: licencias_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.licencias_codigo_seq', 6, true);


--
-- Name: personas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personas_id_seq', 18, true);


--
-- Name: transportistas_licencias_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transportistas_licencias_id_seq', 18, true);


--
-- Name: licencias licencias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.licencias
    ADD CONSTRAINT licencias_pkey PRIMARY KEY (codigo);


--
-- Name: personas personas_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_id_key UNIQUE (id);


--
-- Name: personas personas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY (documento);


--
-- Name: transportistas_licencias transportistas_licencias_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transportistas_licencias
    ADD CONSTRAINT transportistas_licencias_id_key UNIQUE (id);


--
-- Name: transportistas_licencias transportistas_licencias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transportistas_licencias
    ADD CONSTRAINT transportistas_licencias_pkey PRIMARY KEY (transportista, licencia);


--
-- Name: personas trg_actualizar_identificacion_transportista; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trg_actualizar_identificacion_transportista AFTER UPDATE OF documento ON public.personas FOR EACH ROW EXECUTE FUNCTION public.actualizar_identificacion_transportista();


--
-- Name: transportistas_licencias transportistas_licencias_licencia_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transportistas_licencias
    ADD CONSTRAINT transportistas_licencias_licencia_fkey FOREIGN KEY (licencia) REFERENCES public.licencias(codigo);


--
-- Name: transportistas_licencias transportistas_licencias_transportista_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transportistas_licencias
    ADD CONSTRAINT transportistas_licencias_transportista_fkey FOREIGN KEY (transportista) REFERENCES public.personas(documento);


--
-- PostgreSQL database dump complete
--

