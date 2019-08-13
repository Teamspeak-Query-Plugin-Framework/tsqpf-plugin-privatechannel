# Private Channel Plugin for TSQPF

A plugin for the Teamspeak Query Plugin Framework which allows users to create temporary channels.

## Features
- Allows users to create private temporary channels easily

## Getting Started

### Prerequisites

#### Cross-Platform
- Teamspeak Query Plugin Framework
- Java 8

#### Plugins
- WelcomeMessage([repository](https://github.com/Vortexdata/tsqpf-plugin-welcomemessage))

### Download

   Download the latest release from this repository.
   
### Installation

   Copy "tsqpf-plugin-privatechannel-X.X.X.jar" to the plugin folder and reload / restart the framework.
   
   The framework will generate the plugin directory with a plugin.conf file. Before using it, please check this file and adjust the values to fit your server.

### Usage

   Connect to your Teamspeak server, open the frameworks chat window and send '!channel'. You will receive a syntax notice. If you want to create a channel use '!channel <password>'. 
