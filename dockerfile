FROM node:14 as builder

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .


EXPOSE 4600

CMD ["npm", "start"]
