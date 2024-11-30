Para subir o banco rodar:
docker-compose up --build

Modelo para criar um Part:
curl --location 'localhost:3000/bike/parts/urban' \
--header 'Content-Type: application/json' \
--data '[
    {
        "title": "teste de part da frente 1",
        "image": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNDiJcaEEO1YljMfABe6Hps-3x21Ci4C2TDQ&s", 
        "type": "FRONT_FRAME"
    }
]'

EndPoint para requisitar peças:
curl --location 'localhost:3000/bike/parts/urban'
