# Use an official Node.js runtime as a base image
FROM node:22-alpine

# Set the working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package*.json ./
RUN npm install --production

# Copy the rest of your application code
COPY . .

# Build the NestJS application (if using a build step)
RUN npm run build

# Expose the port on which the app runs
EXPOSE 3002

# Start the NestJS application
CMD ["node", "dist/main.js"]
