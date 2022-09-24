FROM node:18.8.0-alpine as build

# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install app dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm install --silent
RUN npm install react-scripts@3.4.1 -g --silent

# add app
COPY . ./

# start app
CMD ["npm", "start"]







#WORKDIR /app
#COPY package.json ./
#COPY package-lock.json ./
#RUN npm install
#COPY . ./
#RUN npm run build
#
##run
#FROM nginx:stable-alpine
#COPY --from=build /app/build /usr/share/nginx/html
## COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
#EXPOSE 28
#CMD ["nginx", "-g", "daemon off;"]