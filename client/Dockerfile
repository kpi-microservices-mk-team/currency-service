FROM node:18.8.0-alpine as build
WORKDIR /app
COPY client/package.json ./
COPY client/package-lock.json ./
RUN npm install
COPY client/. ./
RUN npm run build

#run
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
# COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]




#FROM node:16-alpine as build
#
## set working directory
#WORKDIR /app
#
## install app dependencies
#COPY package.json .
#COPY package-lock.json .
#
#RUN npm install
#
## add app
#COPY . .
#
#RUN npm run build
#
#EXPOSE 80
#
## start app
#CMD ["npm", "start"]
