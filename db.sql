PGDMP         *        
    
    w            postgres    12.0    12.0     0           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            1           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            2           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            3           1262    13318    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
                postgres    false            )          0    16407    cats 
   TABLE DATA           =   COPY public.cats (id, name, ava_link, cnt_likes) FROM stdin;
    public          postgres    false    206   �	       -          0    16433 
   liked_cats 
   TABLE DATA           :   COPY public.liked_cats (id, user_id, cats_id) FROM stdin;
    public          postgres    false    210   �       +          0    16419    role_authorities 
   TABLE DATA           <   COPY public.role_authorities (id, role, action) FROM stdin;
    public          postgres    false    208   a       '          0    16395    users 
   TABLE DATA           U   COPY public.users (id, name, surname, login, password, role, is_enabled) FROM stdin;
    public          postgres    false    204   �       :           0    0    cats_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.cats_id_seq', 14, true);
          public          postgres    false    205            ;           0    0    liked_cats_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.liked_cats_id_seq', 49, true);
          public          postgres    false    209            <           0    0    role_authorities_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.role_authorities_id_seq', 4, true);
          public          postgres    false    207            =           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 2, true);
          public          postgres    false    203            )   �  x���͎�0���)x���f3�?R�J�,p 6�� O_�IW��EX�����ù�f �4�ƶ��w�dP�Pvv����r(�%�J�׺9����Z%c�YY%�8I�IJ�]b]�ja��n5\=YoiFS&�՜����׀G�_t�؅<A/�qaok[�p�.�5l7b'X�nm��Vr���;鍅�WFxz��:K#�A�u���~����9�c�^�z�(�g1;��h��_����l�"�hvB��|��}�x�>C��h�1Q��/	G��:Y>�˹�#�2��a�j_��&L��>��r&�g�Ȳ�N"L�s��e�3RТ��	,ʊ�Un� ��h����M!�4�o�5���"��W��.	!���Q4S��:��z�sX���=�Q�)ʊ �Og]�;����^���q�D%�[�=�)��B�| &#q��w�%҄�n��=G<��=�� m�^�ޢM}��)�~�(��T�      -   �   x�-��0�Q1���K��#�Aõ��}�� SB�L�X/�+9N�n�	)fU3WQk��֥���#�]u}�>���Lz����Y˾$��O?���V��e���v9��[����0m��x�@����;�:�Z��B�����/      +   I   x�3�,-N-�v�wq�p�wr��t�2�LL���C�su��2B��������d��	&����� �C      '   �   x�3�K,�J�(-����,sT�*U�UJr=s�<2�*C=�L�ӳ�]��2�M2�K}��B���M�͓s"���2��L�9K�S�8K�9�S��S+9�3�s�K2�CDT��7>1%hR	W� �/;�     