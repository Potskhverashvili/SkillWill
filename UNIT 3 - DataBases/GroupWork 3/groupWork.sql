PGDMP      +                |            e_commerce_app    16.3    16.3 %    
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16609    e_commerce_app    DATABASE     �   CREATE DATABASE e_commerce_app WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United Kingdom.1252';
    DROP DATABASE e_commerce_app;
                postgres    false            �            1259    16720    cart    TABLE     �   CREATE TABLE public.cart (
    cart_id integer NOT NULL,
    product_quantity integer NOT NULL,
    user_id integer,
    product_id integer,
    product_price integer NOT NULL
);
    DROP TABLE public.cart;
       public         heap    postgres    false            �            1259    16719    cart_cart_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cart_cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cart_cart_id_seq;
       public          postgres    false    222                       0    0    cart_cart_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cart_cart_id_seq OWNED BY public.cart.cart_id;
          public          postgres    false    221            �            1259    16680    orders    TABLE     �   CREATE TABLE public.orders (
    order_id integer NOT NULL,
    paid_price numeric,
    product_quantity integer NOT NULL,
    user_id integer NOT NULL,
    product_id integer NOT NULL
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16679    orders_id_seq    SEQUENCE     �   CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.orders_id_seq;
       public          postgres    false    220                       0    0    orders_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.order_id;
          public          postgres    false    219            �            1259    16673    products    TABLE     �   CREATE TABLE public.products (
    id integer NOT NULL,
    product_price numeric(10,3) NOT NULL,
    product_name character varying(255) NOT NULL,
    product_quantity integer NOT NULL
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    16672    products_id_seq    SEQUENCE     �   CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.products_id_seq;
       public          postgres    false    218                       0    0    products_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;
          public          postgres    false    217            �            1259    16662    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    user_name character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    date_of_birth date
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16661    users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public          postgres    false    216                       0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
          public          postgres    false    215            b           2604    16723    cart cart_id    DEFAULT     l   ALTER TABLE ONLY public.cart ALTER COLUMN cart_id SET DEFAULT nextval('public.cart_cart_id_seq'::regclass);
 ;   ALTER TABLE public.cart ALTER COLUMN cart_id DROP DEFAULT;
       public          postgres    false    221    222    222            a           2604    16683    orders order_id    DEFAULT     l   ALTER TABLE ONLY public.orders ALTER COLUMN order_id SET DEFAULT nextval('public.orders_id_seq'::regclass);
 >   ALTER TABLE public.orders ALTER COLUMN order_id DROP DEFAULT;
       public          postgres    false    219    220    220            `           2604    16676    products id    DEFAULT     j   ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);
 :   ALTER TABLE public.products ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            _           2604    16665    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216                      0    16720    cart 
   TABLE DATA           ]   COPY public.cart (cart_id, product_quantity, user_id, product_id, product_price) FROM stdin;
    public          postgres    false    222   (                 0    16680    orders 
   TABLE DATA           ]   COPY public.orders (order_id, paid_price, product_quantity, user_id, product_id) FROM stdin;
    public          postgres    false    220   r(                 0    16673    products 
   TABLE DATA           U   COPY public.products (id, product_price, product_name, product_quantity) FROM stdin;
    public          postgres    false    218   �(                 0    16662    users 
   TABLE DATA           T   COPY public.users (id, user_name, first_name, last_name, date_of_birth) FROM stdin;
    public          postgres    false    216   \)                  0    0    cart_cart_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cart_cart_id_seq', 10, true);
          public          postgres    false    221                       0    0    orders_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.orders_id_seq', 34, true);
          public          postgres    false    219                       0    0    products_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.products_id_seq', 10, true);
          public          postgres    false    217                       0    0    users_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.users_id_seq', 10, true);
          public          postgres    false    215            l           2606    16725    cart cart_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_id);
 8   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_pkey;
       public            postgres    false    222            j           2606    16687    orders orders_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (order_id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    220            h           2606    16678    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    218            d           2606    16669    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216            f           2606    16671    users users_user_name_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_user_name_key UNIQUE (user_name);
 C   ALTER TABLE ONLY public.users DROP CONSTRAINT users_user_name_key;
       public            postgres    false    216            m           2606    16693    orders product_fk    FK CONSTRAINT     v   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.products(id);
 ;   ALTER TABLE ONLY public.orders DROP CONSTRAINT product_fk;
       public          postgres    false    218    4712    220            o           2606    16731    cart product_fk    FK CONSTRAINT     t   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT product_fk FOREIGN KEY (product_id) REFERENCES public.products(id);
 9   ALTER TABLE ONLY public.cart DROP CONSTRAINT product_fk;
       public          postgres    false    4712    218    222            n           2606    16688    orders user_fk    FK CONSTRAINT     m   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id);
 8   ALTER TABLE ONLY public.orders DROP CONSTRAINT user_fk;
       public          postgres    false    216    4708    220            p           2606    16726    cart user_fk    FK CONSTRAINT     k   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.users(id);
 6   ALTER TABLE ONLY public.cart DROP CONSTRAINT user_fk;
       public          postgres    false    216    4708    222               F   x�M���@�P�C.�iz��:�y0�8F�a��(1�L�8a��x��0�߯��Fk�k7$B���:^         1   x�36ⴴԳ�0�4Bc.cN߄ӌ�؀�ȷR@h����� ��         �   x�M��
�0�����n����EPA��%���	iD�{C���cvfb7�2�.�!̤P��t)�1��05����+/(����o�o#ZC�W>�O\ �iU�^�G���؟�S	SW��2zw�	Rv,��v��eUFS��i�s	j�놈�]�3�         �   x�-��j�0F�?����4�s�v��^���ApZoq�������� 8	�;.��o�Xb��qJ#t�Ԭjֆ�Ե7lR��cp�$skY+6�p�]�����69�F���Պ8��pj'<�}׾|12e]S?�8��
��O>��ʰ���Wv㥽�7�T6����V��Nd^
�O>�mV�"D��,W^q����|VE��:��{[��%Q�,Ui�
gw�H� ���/��w�����<7b�     