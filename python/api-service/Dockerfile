FROM python:3.9.13-slim

COPY . /app
WORKDIR /app

RUN pip install pipenv
RUN pipenv install --ignore-pipfile

CMD ["pipenv", "run", "uvicorn", "src.app:app"]