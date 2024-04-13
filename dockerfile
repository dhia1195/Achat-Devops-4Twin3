FROM node:14 as builder

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build --prod

EXPOSE 4600

CMD ["npm", "start"]
